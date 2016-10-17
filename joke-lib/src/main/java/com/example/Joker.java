package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    List<String> insane = Arrays.asList("Very neat! That ugly head of yours does have a brain!",
            "I\'m not mad at all! I\'m just differently sane!!",
            "Madness is the emergency exit. You can just step outside, and close the door on all those dreadful things that happened. You can lock them away... forever.",
            "See, there were these two guys in a lunatic asylum...and one night, one night they decide they don\'t like living in an asylum any more. They decide they\'re going to escape! So, like, they get up onto the roof and there, just across this narrow gap, they see the rooftops of the town, stretching away in the moonlight...stretching away to freedom. Now, the first guy, he jumps right across with no problem. But his friend, his friend daredn\'t make the leap. Y\'see...y\'see, he\'s afraid of falling. So then, the first guy has an idea...He says \'Hey! I have my flashlight with me! I\'ll shine it across the gap between the buildings. You can walk along the beam and join me!\' B-but the second guy just shakes his head. He suh-says... he says \'What do you think I am? Crazy? You\'d turn it off when I was half way across!\'");

    public String getJQuote(){
        Random rand = new Random();
        int n = rand.nextInt(4);
        return insane.get(n);
    }
}
