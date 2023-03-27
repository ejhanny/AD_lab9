package edu.mines.csci448.examples.samodelkin.presentation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Ledu/mines/csci448/examples/samodelkin/presentation/viewmodel/SamodelkinViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentRepo", "Ledu/mines/csci448/examples/samodelkin/data/SamodelkinRepo;", "getCurrentRepo", "()Ledu/mines/csci448/examples/samodelkin/data/SamodelkinRepo;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getViewModelClass", "Ledu/mines/csci448/examples/samodelkin/presentation/viewmodel/SamodelkinViewModel;", "Companion", "app_debug"})
public final class SamodelkinViewModelFactory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModelFactory.Companion Companion = null;
    private static final java.lang.String LOG_TAG = "448.SamodelkinViewModelFactory";
    @org.jetbrains.annotations.NotNull()
    private final edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo currentRepo = null;
    
    public SamodelkinViewModelFactory(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel> getViewModelClass() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo getCurrentRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ledu/mines/csci448/examples/samodelkin/presentation/viewmodel/SamodelkinViewModelFactory$Companion;", "", "()V", "LOG_TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}