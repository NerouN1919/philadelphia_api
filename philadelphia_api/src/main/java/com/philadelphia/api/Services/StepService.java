package com.philadelphia.api.Services;

import com.philadelphia.api.DAO.StepDAO;
import com.philadelphia.api.DTO.AddStepDTO;
import com.philadelphia.api.DTO.MDFileStepDTO;
import com.philadelphia.api.DTO.QuestionStepDTO;
import com.philadelphia.api.DTO.VideoStepDTO;
import com.philadelphia.api.Database.Steps;
import com.philadelphia.api.Errors.Failed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class StepService {
    @Autowired
    private StepDAO stepDAO;
    public void addStep(AddStepDTO addStepDTO){
        switch (addStepDTO.getType()){
            case VIDEO -> {
                stepDAO.addVideoStep(addStepDTO.getName(), addStepDTO.getVideo(), addStepDTO.getNumber()
                        , addStepDTO.getUnitNumber());
            }
            case MDFILE -> {
                stepDAO.addMDStep(addStepDTO.getName(), addStepDTO.getMdFile(), addStepDTO.getNumber()
                        , addStepDTO.getUnitNumber());
            }
            case QUESTIONS -> {
                Random random = new Random();
                StringBuilder fileName = new StringBuilder();
                for (int i = 0; i < 20; i++) {
                    fileName.append((char) (random.nextInt(26) + 'a'));
                }
                File directory = new File("Questions");
                if(!directory.exists()){
                    directory.mkdir();
                }
                Path path = Paths.get("Questions/" + fileName + ".txt");
                try {
                    Files.createFile(path);
                    BufferedWriter writer = Files.newBufferedWriter(path);
                    writer.write(addStepDTO.getQuestion() + "\n");
                    for(String in : addStepDTO.getOptions()){
                        writer.write(in + "\n");
                    }
                    writer.write(addStepDTO.getCorrectAnswer());
                    writer.close();
                } catch (IOException e) {
                    throw new Failed("Try again");
                }
                stepDAO.addQuestionStep(addStepDTO.getName(), addStepDTO.getNumber()
                        , addStepDTO.getUnitNumber(), fileName.toString());
            }
            default -> throw new Failed("Bad type of step");
        }
    }
    public Object getStepByNumber(Long number){
        List<Steps> steps = stepDAO.getStepByNumber(number);
        if(steps.size()==0){
            throw new Failed("Doesn't have such step");
        }
        Steps step = steps.get(0);
        switch (step.getType()){
            case VIDEO -> {
                return VideoStepDTO.builder().name(step.getName()).video(step.getVideo())
                        .type(step.getType()).number(step.getNumber()).build();
            }
            case MDFILE -> {return MDFileStepDTO.builder().name(step.getName()).mdFile(step.getMdFile())
                    .type(step.getType()).number(step.getNumber()).build();}
            case QUESTIONS -> {
                String question;
                List<String> options = new ArrayList<>();
                String correctAnswer;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./Questions/" +
                            step.getQuestion() + ".txt"));
                    question = bufferedReader.readLine();
                    for (int i = 0; i < 3; i++) {
                        options.add(bufferedReader.readLine());
                    }
                    correctAnswer = bufferedReader.readLine();
                } catch (IOException e){
                    throw new Failed("No such file"); //�������� �� ������� �����
                }
                return QuestionStepDTO.builder().name(step.getName()).number(step.getNumber()).type(step.getType())
                        .question(question).correctAnswer(correctAnswer).options(options).build();
            }
            default -> {throw new Failed("Bad type in step");}
        }
    }
}
