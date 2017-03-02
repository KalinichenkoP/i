package org.igov.model.action.event;

public enum HistoryEventType {

    CUSTOM(0L,
            "custom",
            "Частный тип",
            ""),
    GET_SERVICE(1L,
            "getService",
            "Пользователь воспользовался услугой на портале",
            "Ви подали заявку на послугу " + HistoryEventMessage.SERVICE_NAME
                    + ". \n Cтатус: " + HistoryEventMessage.SERVICE_STATE),
    SET_DOCUMENT_INTERNAL(2L,
            "setDocument_internal",
            "В Мои документы пользователя загружен новый документ – через наш портал",
            HistoryEventMessage.ORGANIZATION_NAME + " завантажує " + HistoryEventMessage.DOCUMENT_TYPE
                    + " " + HistoryEventMessage.DOCUMENT_NAME + " у Ваш розділ Мої документи"),
    SET_DOCUMENT_EXTERNAL(3L,
            "setDocument_external",
            "В Мои документы пользователя загружен новый документ – внешняя организация",
            HistoryEventMessage.ORGANIZATION_NAME + " завантажує " + HistoryEventMessage.DOCUMENT_TYPE
                    + " " + HistoryEventMessage.DOCUMENT_NAME + " у Ваш розділ Мої документи"),
    SET_DOCUMENT_ACCESS_LINK(4L,
            "setDocumentAccessLink",
            "Пользователь предоставил доступ к своему документу",
            "Ви надаєте доступ до документу "
                    + HistoryEventMessage.DOCUMENT_TYPE + " " + HistoryEventMessage.DOCUMENT_NAME
                    + " іншій людині: " + HistoryEventMessage.FIO
                    + " (телефон: " + HistoryEventMessage.TELEPHONE
                    + ", e-mail: " + HistoryEventMessage.EMAIL
                    + ", термiн дії: " + HistoryEventMessage.DAYS + " днів)"),
    SET_DOCUMENT_ACCESS(5L,
            "setDocumentAccess",
            "Кто-то воспользовался доступом к документу через OTP, который ему предоставил пользователь",
            "" + HistoryEventMessage.FIO + " скористався доступом, який Ви надали, та переглянув документ "
                    + HistoryEventMessage.DOCUMENT_TYPE + " " + HistoryEventMessage.DOCUMENT_NAME + ""),
    ACTIVITY_STATUS_NEW(6L,
            "ActivitiStatusNew",
            "Изменение статуса заявки",
            "Ваша заявка №" + HistoryEventMessage.TASK_NUMBER
                    + " змiнила свiй статус на " + HistoryEventMessage.SERVICE_STATE + ""),
    GET_DOCUMENT_ACCESS_BY_HANDLER(7L,
            "getDocumentAccessByHandler",
            "Кто-то воспользовался доступом к документу, который ему предоставил пользователь",
            "Організація " + HistoryEventMessage.ORGANIZATION_NAME
                    + " скористалась доступом, який Ви надали, та переглянула документ "
                    + HistoryEventMessage.DOCUMENT_TYPE + " " + HistoryEventMessage.DOCUMENT_NAME + ""),
    FINISH_SERVICE(8L,
            "ActivitiFinish",
            "Выполнение заявки",
            "Ваша заявка №" + HistoryEventMessage.TASK_NUMBER + " виконана"),
    SET_TASK_QUESTIONS(9L,
            "ActivitiFinish",
            "Запрос на уточнение данных",
            "По заявці №" + HistoryEventMessage.TASK_NUMBER + " задане прохання уточнення:\n"
                    + HistoryEventMessage.S_BODY + "\n"
                    + HistoryEventMessage.TABLE_BODY),
    SET_TASK_ANSWERS(10L,
            "ActivitiFinish",
            "Ответ на запрос об уточнении данных",
            "По заявці №" + HistoryEventMessage.TASK_NUMBER + " дана відповідь громадянином:\n"
                    + HistoryEventMessage.S_BODY + "\n"
                    + HistoryEventMessage.TABLE_BODY),
    CREATING_DOCUMENT(11L,
            "DocumentCreating",
            "Нажата кнопка \"створити документ\"",
            "Створення документу " + HistoryEventMessage.ORDER_ID),
    CREATE_DOCUMENT(12L,
            "DocumentCreated",
            "Нажата кнопка \"створити\"",
            HistoryEventMessage.FIO + "  - документ відредаговано автором"),
    SIGNE_DOCUMENT(13L,
            "DocumentSigned",
            "Нажата кнопка \"підписати\" или \"ознайомлен\"",
            HistoryEventMessage.FIO + " - документ завізовано"),
    CHANGE_DOCUMENT(14L,
            "DocumentChanged",
            "Внесены изменения в документ или задачу (Слушатель SetTask)",
            HistoryEventMessage.FIO + " - документ відредаговано:\n" +
            "Було: " + HistoryEventMessage.OLD_DATA + "\n" +
            "Стало: " + HistoryEventMessage.NEW_DATA),         
    CREATE_SUBDOCUMENT(15L,
            "SubDocumentCreated",
            "В текущем процессе вызван другой процесс (с помощью элемента БП callActiviti)",
            "Створено вкладений документ\n" + HistoryEventMessage.ORDER_ID 
            + "\n" + HistoryEventMessage.BP_ID),
    CHANGE_DOCUMENT_STEP(16L,
            "DocumentChangeStep",
            "Изменился статус документа (переход с одной юзертаски на другую)",
            "Статус документа змінено - " + HistoryEventMessage.SERVICE_STATE),
    MENTION_DOCUMENT(17L,
            "DocumentMentioned",
            "Документ упомянули в другом документе",
            "Документ" + HistoryEventMessage.ORDER_ID + "пов'язаний з іншим" 
            + HistoryEventMessage.LINKED_ORDER_ID),
    CLOSE_DOCUMENT(18L,
            "DocumentClosed",
            "Процесс дошел до конца и закрылся",
            "Документ перміщено до архіву");

    private Long nID;
    private String sID;
    private String sName;
    private String sTemplate;

    private HistoryEventType(Long nID, String sID, String sName, String sTemplate) {
        this.nID = nID;
        this.sID = sID;
        this.sName = sName;
        this.sTemplate = sTemplate;
    }

    public static HistoryEventType getById(Long id) {
        if (id != null) {
            for (HistoryEventType eventType : values()) {
                if (eventType.nID.equals(id)) {
                    return eventType;
                }
            }
        }
        return null;
    }

    public Long getnID() {
        return nID;
    }

    public String getsID() {
        return sID;
    }

    public String getsName() {
        return sName;
    }

    public String getsTemplate() {
        return sTemplate;
    }

}

