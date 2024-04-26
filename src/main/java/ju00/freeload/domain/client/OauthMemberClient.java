package ju00.freeload.domain.client;

import ju00.freeload.domain.OauthMember;
import ju00.freeload.domain.OauthServerType;



public interface OauthMemberClient {

    OauthServerType supportServer();

    OauthMember fetch(String code);
}
