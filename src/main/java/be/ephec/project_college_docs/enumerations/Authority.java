package be.ephec.project_college_docs.enumerations;

import static be.ephec.project_college_docs.constants.Constant.*;

/**
 * This Enum that strictly defines the available roles in the application and maps them to specific sets of permissions (authorities).
 */
public enum Authority {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;

    Authority(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
