package com.krupoderov.fierypontianak.activity;

import com.krupoderov.fierypontianak.model.Person;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloActivity {
  String hello(Person person);
}