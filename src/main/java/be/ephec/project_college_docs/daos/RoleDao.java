package be.ephec.project_college_docs.daos;

import be.ephec.project_college_docs.enumerations.Authority;

public class RoleDao extends Auditable{
    private String name;
    private Authority permissions;
}
