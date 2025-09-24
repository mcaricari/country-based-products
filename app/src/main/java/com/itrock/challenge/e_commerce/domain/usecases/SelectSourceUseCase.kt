package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

/**
 * A use case responsible for selecting the active data source for products.
 * It utilizes a [SourceSelector] to manage the source selection logic.
 *
 * @param sourceSelector The [SourceSelector] used to set the desired data source.
 */
class SelectSourceUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {

    /**
     * Executes the use case to select a data source.
     *
     * @param id An identifier used by the [SourceSelector] to determine
     *           which data source to make active.
     */
    operator fun invoke(id: Int) = sourceSelector.selectSource(id)
}
