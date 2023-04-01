package com.philadelphia.api.Services;

import com.philadelphia.api.DAO.StepDAO;
import com.philadelphia.api.DTO.AddStepDTO;
import com.philadelphia.api.Errors.Failed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            case BOSS -> {

            }
            default -> throw new Failed("Bad type of step");
        }
    }
}
