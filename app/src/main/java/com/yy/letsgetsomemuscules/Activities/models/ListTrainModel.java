package com.yy.letsgetsomemuscules.Activities.models;

public class ListTrainModel {
    String exName;
    String finalCount;
    String documentId;

    public ListTrainModel() {
    }

    public ListTrainModel(String exName, String finalCount) {
        this.exName = exName;
        this.finalCount = finalCount;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getFinalCount() {
        return finalCount;
    }

    public void setFinalCount(String finalCount) {
        this.finalCount = finalCount;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
