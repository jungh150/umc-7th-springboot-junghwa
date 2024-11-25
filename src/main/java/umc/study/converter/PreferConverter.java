package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.mapping.Prefer;

import java.util.List;
import java.util.stream.Collectors;

public class PreferConverter {

    public static List<Prefer> toPreferList(List<Food> foodList){

        return foodList.stream()
                .map(food ->
                        Prefer.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}