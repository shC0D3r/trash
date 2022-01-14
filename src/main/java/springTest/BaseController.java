package springTest;

import Kafaka.MsgController;
import dao.NewHeroDAO;
import models.Hero;
import models.NewHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import utils.db;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/hero")
public class BaseController {

    @Autowired
    private MsgController msgController;

    @GetMapping
    public Hero hero(@RequestParam(value = "id") int id ) throws SQLException, ClassNotFoundException {
        return db.readHero(id);
    }

    @PostMapping("/getHero")
    public Hero getHero(@Valid @RequestBody Hero hero){
        hero.setId(100);
        return hero;
    }

    @GetMapping("/testing")//JDBC
    public String testing( ){
        MySQLController.testJDBC();
        return "Test complete!";
    }

    @PostMapping("/saveHero")//Hibernate
    public String saveHero(@Valid @RequestBody NewHero hero){
        NewHeroDAO DAO = new NewHeroDAO();
        DAO.save(hero);
        return "Герой "+hero.getName()+" был сохранен!";
    }

    @PostMapping("kafka/send")
    public void sendHero(@Valid @RequestBody NewHero hero){
        msgController.sendHero("First_request", hero);
        System.out.println("Отправлено в первый топик!");
    }

    }