package store.proxy.access.service;

import store.domain.Authority;
import store.domain.User;

public class LimitedAccessProxy implements Info {

    private AdminInfo adminInfo;
    private User user;

    public LimitedAccessProxy() {
        adminInfo = AdminInfo.getAdminInfoInstance();
    }

    @Override
    public String getAdminInfo() {
        if(user.getAuthorities().contains(Authority.Role.ADMIN)){
            return adminInfo.getAdminInfo();
        }
        return "Acces denied!";
    }
}
