package devexchanges.info.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import devexchanges.info.materialdesignnavigationdrawer.R;

public class ContentFragment extends Fragment {

    private TextView socialNetworkName;
    private TextView country;
    private ImageView image;

    public static ContentFragment newInstance(SocialNetwork nw) {
        Bundle args = new Bundle();
        ContentFragment fragment = new ContentFragment();
        args.putString("SN_NAME", nw.getName());
        args.putInt("SN_LOGO", nw.getBigImageId());
        args.putString("SN_COUNTRY", nw.getCountry());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        socialNetworkName = (TextView)view.findViewById(R.id.social_network);
        country = (TextView)view.findViewById(R.id.country);
        image = (ImageView)view.findViewById(R.id.icon);

        updateData();
    }

    private void updateData() {
        socialNetworkName.setText(getArguments().getString("SN_NAME"));
        image.setImageResource(getArguments().getInt("SN_LOGO"));
        country.setText(getArguments().getString("SN_COUNTRY"));
    }
}
