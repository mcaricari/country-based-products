package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import com.itrock.challenge.e_commerce.domain.model.Product
import javax.inject.Inject

/**
 * A use case responsible for retrieving a list of all available products.
 * It utilizes a [SourceSelector] to determine the data source from which
 * to fetch the products.
 *
 * @param sourceSelector The [SourceSelector] used to obtain the appropriate [ProductsRepository].
 */
class GetProductsUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {

    /**
     * Executes the use case to fetch all products.
     *
     * @return A list of [Product] objects. Can be an empty list if no products are available.
     */
    suspend operator fun invoke(): List<Product> = sourceSelector.getSource().getProducts()
}
