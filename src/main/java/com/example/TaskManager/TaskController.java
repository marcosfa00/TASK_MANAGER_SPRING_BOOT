package com.example.TaskManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    // Define the list of Task
    private final List<Task> tasks = new ArrayList<>();

    //Define the View of the Tasks
    @GetMapping("/")
    public String tasks(Model model) {
        model.addAttribute("tasks", tasks); // Here we add to the Model the List of TASKS
        return "viewtasks"; // then we return the View TASK
    }

    // ADD new Task to the List
    // 1º Show the VEW with the Form
    // 2º ADD the Task to the List
    @GetMapping("/add")
    public String addTaskForm() {
        return "addtask";
    }
    @PostMapping("/")
    public String addTask(@RequestParam("title") String title, @RequestParam("description") String description) {
        Task newTask = new Task((tasks.size() +1), title,description);
        tasks.add(newTask);
        return "redirect:/";
    }

    // DELETE Task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/";
    }
    // COMPLETE Task
    @GetMapping("/done/{id}")
    public String doneTask(@PathVariable("id") int id, Model model) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (task.getDone()) {
                    task.setDone(false);

                }else{
                    task.setDone(true);

                }

                break;
            }
        }
        return "redirect:/";
    }



    // EDIT Task
    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable("id") int id, Model model) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                model.addAttribute("task", task);
                break;
            }
        }
        return "edit"; // Devuelve la vista donde se editará la tarea
    }


    // EDIT
    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable("id") int id, @RequestParam("title") String title, @RequestParam("description") String description) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(description);
                break;
            }
        }
        return "redirect:/";
    }

}
