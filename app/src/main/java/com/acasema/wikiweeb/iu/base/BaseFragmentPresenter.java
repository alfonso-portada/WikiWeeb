package com.acasema.wikiweeb.iu.base;

/**
 * interfaz base para los contratos presenter
 */
public interface BaseFragmentPresenter {

    /**
     * este metodo de pone a null el objeto View y interacto dentro del presente
     * si no ocure un error llamado memoryClics cada vez que se crea el presenter
     */
    void onDestroyView();
}
