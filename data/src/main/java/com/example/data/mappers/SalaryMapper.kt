package com.example.data.mappers

import com.example.data.entities.auxiliary_entities.SalaryData
import com.example.domain.entities.auxiliary_entities.Salary

fun SalaryData.toSalary(): Salary {
    return Salary(
        full = this.full,
        short = this.short
    )
}

fun Salary.toSalaryData(): SalaryData {
    return SalaryData(
        full = this.full,
        short = this.short
    )
}