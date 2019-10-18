package restaurant.endpoit.rest;

import api.dto.MealDTO;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restaurant.service.MealService;


@RestController
@RequestMapping("/meal")
public class MealRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(MealRestController.class);

    @Autowired
    MealService service;

    @RequestMapping(method = RequestMethod.POST, path = "/save",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MealDTO save(@RequestBody MealDTO meal) {
        MealDTO mealDTO = service.save(meal);
        LOGGER.info("Created meal : " + mealDTO.toString());
        return mealDTO;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MealDTO update(@RequestBody MealDTO mealDTO) throws NotFoundException {
        try {
            String uuid = service.getByUuid(mealDTO.getUuid()).getUuid();
            mealDTO.setUuid(uuid);
        } catch (NullPointerException e) {
            throw new NotFoundException("Meal with this id not exists, check uuid please");
        }
        MealDTO updatedMeal = service.save(mealDTO);
        LOGGER.info("Updated Meal : " + updatedMeal.toString());
        return service.getByUuid(updatedMeal.getUuid());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MealDTO get(@RequestParam String uuid) throws NotFoundException {
        try {
            MealDTO mealDTO = service.getByUuid(uuid);
            LOGGER.info("get meal : " + mealDTO.toString());
            return mealDTO;
        } catch (NullPointerException e) {
            throw new NotFoundException("Not found Meals with id: " + uuid);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{uuid}")
    public boolean delete(@PathVariable(name = "uuid") String uuid) throws NotFoundException {
        LOGGER.info("delete meal");
        try {
            return service.delete(uuid);
        } catch (NullPointerException e) {
            throw new NotFoundException("Not found Entity with id: " + uuid);
        }
    }
}
