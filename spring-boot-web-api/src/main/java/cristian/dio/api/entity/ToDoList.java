package cristian.dio.api.entity;

import jakarta.persistence.*;

//Entidade que representa a tabela
@Entity(name = "tb_todolist")
public class ToDoList {
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Descrição
    @Column(nullable = false)
    private String description;

    //Status da lista de afazeres
    @Column(nullable = false)
    private String status;

    public ToDoList(){}

    public ToDoList(String description, String status) {
        this.description = description;
        this.status = status;
    }

    //Métodos setters e getters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }


    public String getStatus() {
        return status;
    }

}
