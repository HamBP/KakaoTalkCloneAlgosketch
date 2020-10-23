package org.algosketch.kakaotalkclonealgosketch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_friends);
        List<ItemVO> list = new ArrayList<>();

        for(int i = 0; i < 5; ++i) {
            ProfileVO vo = new ProfileVO();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_selected_speech_bubble, options);
            vo.setProfileImage(bitmap);

            vo.setName("김이름");
            vo.setProfileMassage("상태 메시지");
            list.add(vo);
        }

        HeaderVO hvo = new HeaderVO();
        hvo.setTitle("친구");
        list.add(hvo);

        for(int i = 0; i < 5; ++i) {
            ProfileVO vo = new ProfileVO();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_selected_speech_bubble, options);
            vo.setProfileImage(bitmap);

            vo.setName("김이름");
            vo.setProfileMassage("상태 메시지");
            list.add(vo);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list));

        return view;
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<ItemVO> list;

        public RecyclerViewAdapter(List<ItemVO> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if(viewType == ItemVO.TYPE_PROFILE) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
                return new ProfileViewHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ItemVO vo = list.get(position);

            if(vo.getType() == ItemVO.TYPE_PROFILE) {
                ((ProfileViewHolder)holder).profileImage.setImageBitmap(((ProfileVO)vo).profileImage);
                ((ProfileViewHolder)holder).name.setText(((ProfileVO)vo).name);
                ((ProfileViewHolder)holder).profileMassage.setText(((ProfileVO)vo).profileMassage);
            } else {
                ((HeaderViewHolder)holder).titleView.setText(((HeaderVO)vo).title);
            }
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position).getType();
        }
    }

    abstract class ItemVO {
        public static final int TYPE_PROFILE = 0;
        public static final int TYPE_HEADER = 1;

        abstract int getType();
    }

    class ProfileVO extends ItemVO {
        Bitmap profileImage;
        String name;
        String profileMassage;

        public void setProfileImage(Bitmap profileImage) {
            this.profileImage = profileImage;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setProfileMassage(String profileMassage) {
            this.profileMassage = profileMassage;
        }

        @Override
        int getType() {
            return TYPE_PROFILE;
        }
    }

    class HeaderVO extends ItemVO {
        String title;

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        int getType() {
            return TYPE_HEADER;
        }
    }

    // class
    private class ProfileViewHolder extends RecyclerView.ViewHolder {
        public ImageView profileImage;
        public TextView name;
        public TextView profileMassage;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.img_profile);
            name = itemView.findViewById(R.id.txt_name);
            profileMassage = itemView.findViewById(R.id.txt_profile_massage);
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.txt_header_title);
        }
    }

}
