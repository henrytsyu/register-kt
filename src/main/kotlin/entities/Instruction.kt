package com.henrytsyu.register.entities

sealed class Instruction {

  data object Halt : Instruction()

  data class Increment(val register: Int, val next: Int) : Instruction()

  data class Decrement(val register: Int, val nextSuccess: Int, val nextFail: Int) : Instruction()
}
