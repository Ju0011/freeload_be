package ju00.freeload.domain.authcode;

import ju00.freeload.domain.OauthServerType;


public interface AuthCodeRequestUrlProvider {

    OauthServerType supportServer();

    String provide();
}