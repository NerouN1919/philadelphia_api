# Api for hackaton by EEsTech   
Для запуска в директории с проектом выполнить  
```
./gradlew clean build  
docker-compose build
docker-compose up  
```
Пароль и логин для JWT:  
**Login:"Admin"**  
**Password:"12345"**  
# Structure of DataBase:  
![изображение](https://user-images.githubusercontent.com/99546572/229333287-95d0cc00-1f82-4aef-8eaf-256f7b35a73d.png) 
# Список доступных HTTP запросов:  
![изображение](https://user-images.githubusercontent.com/99546572/229333330-6c3b5a97-fd05-4dda-b0f8-53551ba1623e.png)
![изображение](https://user-images.githubusercontent.com/99546572/229333349-0335564b-dc05-492a-be6a-b3abfc936ff6.png)
## Полная документация: http://neroun.duckdns.org:8080/swagger-ui/index.html#/  
## curl запросы для наполнения базы данных
```
curl --location --request GET 'http://neroun.duckdns.org:8080/api/units' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Обучить сотрудников ТБ",
  "number": 1
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/units' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Первичный инструктаж при приеме на работу: инструкции от HR–специалиста",
  "number": 2
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/units' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Знакомство с Системой RNS Web",
  "number": 3
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/units' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Знакомство с историей компании и целями",
  "number": 4
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/units' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Знакомство с отделами и офисом",
  "number": 5
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 1,
  "type": "MDFILE",
  "number": 1,
  "name": "О технике безопасности",
  "mdFile": "https://github.com/NerouN1919/philadelphia_api/blob/main/md/unit1_1.md"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 1,
  "type": "VIDEO",
  "number": 2,
  "name": "Видео о технике безопасности",
  "video": "https://youtu.be/k72g5H-YaUE"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 1,
  "type": "QUESTIONS",
  "number": 3,
  "name": "Рурика вопросы",
  "question": "Какой вид защиты от поражения электрическим током является наиболее эффективным?",
  "options": [
    "Избегать работы с электрическими устройствами",
    "Использование изолирующих перчаток",
    "Использование защитных очков",
    "Использование защитных наушников"
  ],
  "correctAnswer": "Использование изолирующих перчаток"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 1,
  "type": "QUESTIONS",
  "number": 4,
  "name": "Рубрика вопросы",
  "question": "Какое оборудование необходимо использовать для безопасной работы на высоте?",
  "options": [
    "Лестницы",
    "Строительные леса",
    "Подъемные платформы",
    "Все вышеперечисленное"
  ],
  "correctAnswer": "Все вышеперечисленное"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 2,
  "type": "MDFILE",
  "number": 1,
  "name": "Инструктаж от HR",
  "mdFile": "https://github.com/NerouN1919/philadelphia_api/blob/main/md/unit2_1.md"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 2,
  "type": "VIDEO",
  "number": 2,
  "name": "Знакомство с компанией",
  "video": "https://youtu.be/yqn4uqEkmkw"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 2,
  "type": "QUESTIONS",
  "number": 3,
  "name": "Рубрика вопросы",
  "question": "Какое направление разработки ПО является ключевым для нашей IT-компании?",
  "options": [
    "Web-разработка",
    "Мобильная разработка",
    "Искусственный интеллект",
    "Блокчейн технологии"
  ],
  "correctAnswer": "Мобильная разработка"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 3,
  "type": "MDFILE",
  "number": 1,
  "name": "Система RNS WEB",
  "mdFile": "https://github.com/NerouN1919/philadelphia_api/blob/main/md/unit3_1.md"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 3,
  "type": "VIDEO",
  "number": 2,
  "name": "Пример сайта",
  "video": "https://youtu.be/Q_E3ubazHGg"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 3,
  "type": "QUESTIONS",
  "number": 3,
  "name": "Рубрика вопросы",
  "question": "В каких направлениях занимается компания RuNetSoft?",
  "options": [
    "Только веб-разработка",
    "Frontend и backend разработка, создание мобильных приложений и информационных систем, маркетинг и продвижение в социальных сетях",
    "Только маркетинг и продвижение в социальных сетях",
    "Только создание мобильных приложений"
  ],
  "correctAnswer": "Frontend и backend разработка, создание мобильных приложений и информационных систем, маркетинг и продвижение в социальных сетях"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 4,
  "type": "MDFILE",
  "number": 1,
  "name": "О компании",
  "mdFile": "https://github.com/NerouN1919/philadelphia_api/blob/main/md/unit4_1.md"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 4,
  "type": "VIDEO",
  "number": 2,
  "name": "Расскажем о нашей компании и её целях",
  "video": "https://youtu.be/qML8eoV8rOY"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 4,
  "type": "VIDEO",
  "number": 3,
  "name": "Промо видео",
  "video": "https://youtu.be/Hx9r6TWW1Rg"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 4,
  "type": "QUESTIONS",
  "number": 3,
  "name": "Рубрика вопросы",
  "question": "Какой год является годом основания компании RuNetSoft?",
  "options": [
    "2008",
    "2010",
    "2012",
    "2014"
  ],
  "correctAnswer": "2010"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 5,
  "type": "MDFILE",
  "number": 1,
  "name": "Наш офис",
  "mdFile": "https://github.com/NerouN1919/philadelphia_api/blob/main/md/unit5_1.md"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 5,
  "type": "VIDEO",
  "number": 2,
  "name": "Погружаемся в атмосферу нашего офиса",
  "video": "https://youtu.be/Lto1EBcM-40"
}'

curl --location --request GET 'http://neroun.duckdns.org:8080/api/steps' \
--header 'Authorization: Bearer {token}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "unitNumber": 5,
  "type": "QUESTIONS",
  "number": 3,
  "name": "Рубрика вопросы",
  "question": "Какая форма планировки рабочих мест используется в офисе компании RuNetSoft?",
  "options": [
    "Кабинетная",
    "Смешанная",
    "Открытая",
    "Клеточная"
  ],
  "correctAnswer": "Открытая"
}'
```
# Стек  
- Java 17.0  
- Spring Boot  
- Spring Hibernate  
- Spring Security  
- Spring Data JPA  
- PostgreSQL  
- Docker  
- JWT API
# Backend разработчик -- Сергей Свириденко  



