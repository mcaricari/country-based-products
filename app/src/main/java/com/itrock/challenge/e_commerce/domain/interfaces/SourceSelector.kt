package com.itrock.challenge.e_commerce.domain.interfaces

/**
 * Defines a contract for managing the selection and retrieval
 * of a [ProductsRepository] data source.
 */
interface SourceSelector {

    /**
     * Sets the active data source based on the provided identifier.
     *
     * @param id An identifier used to determine which data source to select.
     */
    fun selectSource(id: Int)

    /**
     * Provides access to the currently selected [ProductsRepository].
     *
     * @return The active [ProductsRepository] instance.
     */
    fun getSource(): ProductsRepository
}
