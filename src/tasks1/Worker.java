package tasks1;

public class Worker {
    
    private String name;//Имя
    private String surname;//Фамилия
    private String patronymic;//Отчество
    
    private int workshop;//Цех
    private int experience;//Опыт работы
    
    public Worker(String name, String surname, String patronymic, int workshop, int experience) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.workshop = workshop;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getWorkshop() {
        return workshop;
    }

    public void setWorkshop(int workshop) {
        this.workshop = workshop;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    
}
