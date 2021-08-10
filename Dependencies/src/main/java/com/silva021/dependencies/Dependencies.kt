package com.silva021.dependencies

class Dependencies {
}

object Retrofit {
    object Versions {
        const val retrofit = "2.9.0"
    }

    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
}