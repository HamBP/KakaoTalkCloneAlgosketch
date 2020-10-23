package org.algosketch.kakaotalkclonealgosketch;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*RecyclerView recyclerView = getView().findViewById(R.id.recyclerview_friends);
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 20; ++i) {
            list.add("Item=" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list));
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration());*/

        return (LinearLayout)inflater.inflate(R.layout.fragment_friends, container, false);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private List<String> list;

        public RecyclerViewAdapter(List<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            String text = list.get(position);
            holder.title.setText(text);
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }
    }

    // class
    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
        }
    }

    // class
    class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int index = parent.getChildAdapterPosition(view) + 1;
            if (index % 3 == 0)
                outRect.set(20, 20, 20, 60);
            else
                outRect.set(20, 20, 20, 20);
            view.setBackgroundColor(0xFFECE9E9);
            ViewCompat.setElevation(view, 20.0f);
        }
    }
}
