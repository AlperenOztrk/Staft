package com.wiuma.staft.models

import com.wiuma.staft.R
import com.wiuma.staft.functions.Functions

enum class Avatars {
    boat, butterfly, camel, canary, crab, crane, dove, dragonfly, duck,
    elephant, fish, flower, fox, frog, hat, heart, jet, kabuto, ladybug,
    lobster, mouse, pelican, penguin, pig, plane, rabbit, ribbon, seal, shark,
    ship, shuriken, star, stingray, turtle, unicorn, whale;

    private val url = "https://staftapp.web.app/staft/avatars/"

    public fun parse(raw: String): Avatars? {
        for (category in values()) {
            if (raw == category.name) {
                return category
            }
        }
        return null
    }

    public fun image(): Int {
//        return R.drawable.enum_avatar_bird
        return Functions.getResId("enum_avatar_$name", R.drawable::class.java)
    }

    public fun imageURL(): String {
        return url + "enum_avatar_$name.png"
    }

}