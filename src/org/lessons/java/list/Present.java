package org.lessons.java.list;

public class Present {

    // Attributi
    private String subject;
    private String description;

    // Costruttori
    public Present(String subject, String description) {
        this.subject = subject;
        this.description = description;
    }

    // Metodi
    public String getDescription() {
        return description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Present{" +
                "subject = '" + subject + '\'' +
                ", description = " + description +
                '}';
    }
}
