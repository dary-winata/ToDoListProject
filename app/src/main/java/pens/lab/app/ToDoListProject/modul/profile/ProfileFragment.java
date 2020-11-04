package pens.lab.app.belajaractivity.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.login.LoginActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements ProfileContract.View {

    TextView tvUsername;
    TextView tvPassword;
    Button btBack;
    Intent intent;

    public ProfileFragment(Intent intent) {
        this.intent = intent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        mPresenter = new ProfilePresenter(this);
        mPresenter.start();

        tvUsername = fragmentView.findViewById(R.id.username_tv);
        tvPassword = fragmentView.findViewById(R.id.password_tv);
        btBack = fragmentView.findViewById(R.id.btBack);
        tampilkanData();

        setTitle("My Profile");

        return fragmentView;
    }

    public void tampilkanData(){
        String[] value = new String[2];

        value = mPresenter.getValueIntent(intent);

        tvUsername.setText(value[0]);
        tvPassword.setText(value[1]);
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
