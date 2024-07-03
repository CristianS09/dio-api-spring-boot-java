package cristian.dio.api.controller;

import cristian.dio.api.entity.ToDoList;
import cristian.dio.api.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    @Autowired
    ToDoListRepository toDoListRepository;

    //Retornar todas as todolist
    @GetMapping("/getall")
    public List<ToDoList> getAllToDoList(){
        return toDoListRepository.findAll();
    }

    //Retorna uma todolist por id
    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getById(@PathVariable Long id){
        Optional<ToDoList> toDoListOptional = toDoListRepository.findById(id);
        if(toDoListOptional.isPresent()){
            return new ResponseEntity<>(toDoListOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Salva uma nova todolist
    @PostMapping
    public ResponseEntity<String> saveToDoList(@RequestBody ToDoList toDoList){
        toDoListRepository.save(toDoList);
        return new ResponseEntity<>("Todo save", HttpStatus.OK);
    }

    //Delete uma todolist
    @DeleteMapping("/{id}")
    //Se o id não existir será lançada uma exeção
    public ResponseEntity<String> deleteToDoList(@PathVariable Long id){
        try{

            if(!toDoListRepository.existsById(id)){
                throw new IllegalArgumentException("Id doesn't exits");
            }

            toDoListRepository.deleteById(id);
            return new ResponseEntity<>("id removed", HttpStatus.OK);
        }catch (Exception exc){
            return new ResponseEntity<>(exc.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
