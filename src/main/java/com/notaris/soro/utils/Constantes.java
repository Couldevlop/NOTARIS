package com.notaris.soro.utils;

public interface Constantes {
    String APP_ROOT ="notaris/v1";
    String CLIENT_BANQUE_END_POINT = APP_ROOT+ "/banques";
    String CLIENT_MORAL_END_POINT = APP_ROOT+ "/moral";
    String CLIENT_PHYSIQUE_END_POINT = APP_ROOT+ "/physiques";
    String ACTE_IMMO_END_POINT = APP_ROOT+ "/acteImmobiliers";
    String TYPE_DOCUMENT_END_POINT = APP_ROOT+ "/typeDocumments";
    String LIQUIDATION_COMMUNAUTE_END_POINT = APP_ROOT+ "/liquidation/communautes";
    String LIQUIDATION_SESSION_END_POINT = APP_ROOT+ "/liquidation/successions";
    String SOCIETE_CONSTITUTION_END_POINT = APP_ROOT+ "/societe/constitutions";

    String NATURE_SOCIETE_END_POINT = APP_ROOT+ "/natureSocietes";

    String TYPE_SOCIETE_END_POINT = APP_ROOT+ "/typeSocietes";

    String OUVERTURE_CREDIT_END_POINT = APP_ROOT + "/ouvertureCredits";

    String SOCIETE_MODIFICATION_END_POINT = APP_ROOT+ "/societe/modifications";

    String PAYS_END_POINT = APP_ROOT+ "/pays";

    String VILLE_END_POINT = APP_ROOT+ "/villes";

    String TYPE_PIECES_END_POINT = APP_ROOT+ "/typePieces";

    String TYPE_PERSONNES_END_POINT = APP_ROOT+ "/typePersonnes";

    String TYPE_SUCCESSIONS_END_POINT = APP_ROOT+ "/typeSuccessions";

    String ROLE_END_POINT =  "notaris/v1/auth/roles";
}
