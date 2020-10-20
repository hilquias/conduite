TARGET := target/conduite-1.0-SNAPSHOT.jar

$(TARGET):
		mvn package

run:
		java -jar $(TARGET) server config.yml

test:
		mvn test

clean:
		mvn clean

db-migrate:
		java -jar $(TARGET) db migrate config.yml


.PHONY: run test clean db-migrate
