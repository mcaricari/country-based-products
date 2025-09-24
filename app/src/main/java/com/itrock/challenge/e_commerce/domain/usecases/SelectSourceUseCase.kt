package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

class SelectSourceUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {
    operator fun invoke(id: Int) = sourceSelector.selectSource(id)
}