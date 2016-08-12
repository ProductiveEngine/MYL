package com.productiveengine.myl.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.productiveengine.myl.BLL.SettingsBL;
import com.productiveengine.myl.Common.HateCriteria;
import com.productiveengine.myl.Common.LoveCriteria;
import com.productiveengine.myl.DomainClasses.Settings;
import com.productiveengine.myl.UIL.BR;

import java.io.Serializable;

public class SettingsVM  extends BaseObservable implements Serializable{

    private Settings settings;
    private String rootFolderPath;
    private String targetFolderPath;
    private String rootFolder;
    private String targetFolder;
    //--------------------------------------------
    private HateCriteria hateCriteria;
    private int hateTimeLimit;
    private int hateTimePercentage;
    //--------------------------------------------
    private LoveCriteria loveCriteria;
    private int loveTimeLimit;
    private int loveTimePercentage;
    //----------------------------------------------
    private boolean screenOn;

    private SettingsBL settingsBL;

    //-------------------------------
    private boolean hateTimeLimitChk;
    private boolean loveTimeLimitChk;

    public SettingsVM() {
        initialize();
    }
    private void initialize(){
        settingsBL = new SettingsBL();
        settings = settingsBL.initializeSettingsFromDB();

        //----------------------------------------------
        rootFolderPath = settings.rootFolderPath;
        targetFolderPath = settings.targetFolderPath;
        rootFolder = settings.rootFolder;
        targetFolder = settings.targetFolder;
        //----------------------------------------------
        loveCriteria = LoveCriteria.fromInt(settings.loveCriteria);

        switch (loveCriteria){
            case TIME_LIMIT:
                setLoveTimeLimitChk(true);
                break;
            case PERCENTAGE:
                setLoveTimeLimitChk(false);
                break;
            default:
                setLoveTimeLimitChk(true);
        }

        loveTimeLimit = settings.loveTimeLimit;
        loveTimePercentage = settings.loveTimePercentage;
        //----------------------------------------------
        hateCriteria = HateCriteria.fromInt(settings.hateCriteria);

        switch (hateCriteria){
            case TIME_LIMIT:
                setHateTimeLimitChk(true);
                break;
            case PERCENTAGE:
                setHateTimeLimitChk(false);
                break;
            default:
                setHateTimeLimitChk(true);
        }

        hateTimeLimit = settings.hateTimeLimit;
        hateTimePercentage = settings.hateTimePercentage;
        //----------------------------------------------
        screenOn = settings.screenOn;
        //----------------------------------------------
    }
    private void notifyAndSave(int fieldId){
        //--------------------------------------------
        settings.rootFolderPath = rootFolderPath;
        settings.targetFolderPath = targetFolderPath;
        settings.rootFolder = rootFolder;
        settings.targetFolder = targetFolder;
        //--------------------------------------------
        if(hateCriteria != null) {
            settings.hateCriteria = hateCriteria.ordinal();
        }
        settings.hateTimeLimit = hateTimeLimit;
        settings.hateTimePercentage = hateTimePercentage;
        //--------------------------------------------
        if(loveCriteria != null) {
            settings.loveCriteria = loveCriteria.ordinal();
        }
        settings.loveTimeLimit = loveTimeLimit;
        settings.loveTimePercentage = loveTimePercentage;
        //--------------------------------------------
        settings.screenOn = screenOn;

        settingsBL.saveData(settings);
        notifyPropertyChanged(fieldId);
    }

    //--------------------------------------------
    //Setters getters
    @Bindable
    public String getRootFolderPath() {
        return rootFolderPath;
    }

    public void setRootFolderPath(String rootFolderPath) {
        this.rootFolderPath = rootFolderPath;
        notifyAndSave(BR.rootFolderPath);
    }

    @Bindable
    public String getTargetFolderPath() {
        return targetFolderPath;
    }

    public void setTargetFolderPath(String targetFolderPath) {
        this.targetFolderPath = targetFolderPath;
        notifyAndSave(BR.targetFolderPath);
    }

    @Bindable
    public String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
        notifyAndSave(BR.rootFolder);
    }

    @Bindable
    public String getTargetFolder() {
        return targetFolder;
    }

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
        notifyAndSave(BR.targetFolder);
    }

    @Bindable
    public LoveCriteria getLoveCriteria() {
        return loveCriteria;
    }

    public void setLoveCriteria(LoveCriteria loveCriteria) {
        this.loveCriteria = loveCriteria;
        notifyAndSave(BR.loveCriteria);
    }

    @Bindable
    public int getLoveTimeLimit() {
        return loveTimeLimit;
    }

    public void setLoveTimeLimit(int loveTimeLimit) {
        this.loveTimeLimit = loveTimeLimit;
        notifyAndSave(BR.loveTimeLimit);
    }

    @Bindable
    public int getLoveTimePercentage() {
        return loveTimePercentage;
    }

    public void setLoveTimePercentage(int loveTimePercentage) {
        this.loveTimePercentage = loveTimePercentage;
        notifyAndSave(BR.loveTimePercentage);
    }

    @Bindable
    public boolean isScreenOn() {
        return screenOn;
    }

    public void setScreenOn(boolean screenOn) {
        this.screenOn = screenOn;
        notifyAndSave(BR.screenOn);
    }

    @Bindable
    public boolean isLoveTimeLimitChk() {
        return loveTimeLimitChk;
    }

    public void setLoveTimeLimitChk(boolean loveTimeLimitChk) {
        this.loveTimeLimitChk = loveTimeLimitChk;
        notifyPropertyChanged(BR.loveTimeLimitChk);
    }

    @Bindable
    public HateCriteria getHateCriteria() {
        return hateCriteria;
    }

    public void setHateCriteria(HateCriteria hateCriteria) {
        this.hateCriteria = hateCriteria;
        notifyAndSave(BR.hateCriteria);
    }

    @Bindable
    public int getHateTimeLimit() {
        return hateTimeLimit;
    }

    public void setHateTimeLimit(int hateTimeLimit) {
        this.hateTimeLimit = hateTimeLimit;
        notifyAndSave(BR.hateTimeLimit);
    }

    @Bindable
    public int getHateTimePercentage() {
        return hateTimePercentage;
    }

    public void setHateTimePercentage(int hateTimePercentage) {
        this.hateTimePercentage = hateTimePercentage;
        notifyAndSave(BR.hateTimePercentage);
    }

    @Bindable
    public boolean isHateTimeLimitChk() {
        return hateTimeLimitChk;
    }

    public void setHateTimeLimitChk(boolean hateTimeLimitChk) {
        this.hateTimeLimitChk = hateTimeLimitChk;
        notifyPropertyChanged(BR.hateTimeLimitChk);
    }
}
