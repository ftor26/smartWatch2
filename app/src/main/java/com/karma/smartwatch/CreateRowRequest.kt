package com.karma.smartwatch

data class CreateRowRequest(
    val record : man,
    val table : String = "data"
)
data class  man(
    val pulse : String,
   val pressure : String
)