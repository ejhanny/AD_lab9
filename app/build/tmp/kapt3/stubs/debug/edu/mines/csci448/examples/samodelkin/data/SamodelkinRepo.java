package edu.mines.csci448.examples.samodelkin.data;

import java.lang.System;

@kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Ledu/mines/csci448/examples/samodelkin/data/SamodelkinRepo;", "", "samodelkinDao", "Ledu/mines/csci448/examples/samodelkin/data/database/SamodelkinDao;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ledu/mines/csci448/examples/samodelkin/data/database/SamodelkinDao;Lkotlinx/coroutines/CoroutineScope;)V", "characters", "", "Ledu/mines/csci448/examples/samodelkin/data/SamodelkinCharacter;", "getCharacters", "()Ljava/util/List;", "addCharacter", "", "samodelkinCharacter", "deleteCharacter", "getCharacter", "uuid", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Companion", "app_debug"})
public final class SamodelkinRepo {
    private final edu.mines.csci448.examples.samodelkin.data.database.SamodelkinDao samodelkinDao = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    public static final edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo.Companion Companion = null;
    private static final java.lang.String LOG_TAG = "448.SamodelkinRepo";
    private static edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter> characters = null;
    
    private SamodelkinRepo(edu.mines.csci448.examples.samodelkin.data.database.SamodelkinDao samodelkinDao, kotlinx.coroutines.CoroutineScope coroutineScope) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter> getCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter>> getCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCharacter(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter> continuation) {
        return null;
    }
    
    public final void addCharacter(@org.jetbrains.annotations.NotNull()
    edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter samodelkinCharacter) {
    }
    
    public final void deleteCharacter(@org.jetbrains.annotations.NotNull()
    edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter samodelkinCharacter) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ledu/mines/csci448/examples/samodelkin/data/SamodelkinRepo$Companion;", "", "()V", "INSTANCE", "Ledu/mines/csci448/examples/samodelkin/data/SamodelkinRepo;", "LOG_TAG", "", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * @param context
         */
        @org.jetbrains.annotations.NotNull()
        public final edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}