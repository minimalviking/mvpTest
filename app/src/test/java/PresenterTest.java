import com.unii.flingtwo.PresenterManager;
import com.unii.flingtwo.login.LoginActivityInterface;
import com.unii.flingtwo.login.LoginPresenterInterface;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {
    @Mock
    LoginActivityInterface loginActivity;

    @Test
    public void testFieldValidation() throws Exception {
        PresenterManager.getInstance().clearPresenters();
        LoginPresenterInterface presenter = PresenterManager.getInstance().getLoginPresenter();
        assertFalse(presenter.isLoginAllowed());
        presenter.onTextChanged("askdhjas@gmail.com", "password");
        assertTrue(presenter.isLoginAllowed());
    }

    @Test
    public void testLoginButtonIsUpdate() throws Exception {
        PresenterManager.getInstance().clearPresenters();
        LoginPresenterInterface presenter = PresenterManager.getInstance().getLoginPresenter();
        presenter.bindView(loginActivity);
        Mockito.verify(loginActivity).setButtonEnabled(false);
        presenter.onTextChanged("askdhjas@gmail.com", "password");
        Mockito.verify(loginActivity).setButtonEnabled(true);
    }
}
