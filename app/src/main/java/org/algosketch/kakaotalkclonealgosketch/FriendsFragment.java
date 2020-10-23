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

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_friends);
        List<ItemVO> list = new ArrayList<>();
        for(int i = 0; i < 20; ++i) {
            ItemVO vo = new ItemVO();

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

    private class RecyclerViewAdapter extends RecyclerView.Adapter<FriendsViewHolder> {
        private List<ItemVO> list;

        public RecyclerViewAdapter(List<ItemVO> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
            return new FriendsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
            ItemVO vo = list.get(position);
            holder.profileImage.setImageBitmap(vo.profileImage);
            holder.name.setText(vo.name);
            holder.profileMassage.setText(vo.profileMassage);
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }
    }

    class ItemVO {
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
    }

    // class
    private class FriendsViewHolder extends RecyclerView.ViewHolder {
        public ImageView profileImage;
        public TextView name;
        public TextView profileMassage;

        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.img_profile);
            name = itemView.findViewById(R.id.txt_name);
            profileMassage = itemView.findViewById(R.id.txt_profile_massage);
        }
    }

}
