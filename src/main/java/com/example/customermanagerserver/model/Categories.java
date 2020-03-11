package com.example.customermanagerserver.model;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class Categories {

    private List<String> categories = Lists.newArrayList("firma prywatna", "spółka krajowa", "spółka zagraniczna");
}
