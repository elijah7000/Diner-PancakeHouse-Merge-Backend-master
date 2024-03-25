package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MergerController {

    @Autowired
    private DinerRepository dinerRepository;

    @Autowired
    private PancakeHouseRepository pancakeHouseRepository;

    @GetMapping("/merger")
    public List<MenuItem> mergeMenus() {

        List<MenuItem> dinerMenu = dinerRepository.findAll();
        List<MenuItem> pancakeHouseMenu = pancakeHouseRepository.findAll();

        List<MenuItem> mergedMenu = new ArrayList<>(dinerMenu);
        mergedMenu.addAll(pancakeHouseMenu);

        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}