package az.adnsu.studentparticipate.rest;

import az.adnsu.studentparticipate.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ParticipateController {

   @Autowired
   private ParticipateService service;

   @GetMapping(path = "/register/{cardId}")
   @CrossOrigin
   public ResponseEntity register(@PathVariable("cardId") String cardId){

        service.register(cardId);

        return ResponseEntity.ok().build();
   }

    @GetMapping(path = "/list")
    @CrossOrigin
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.findParticipleEntityList());
    }


}
