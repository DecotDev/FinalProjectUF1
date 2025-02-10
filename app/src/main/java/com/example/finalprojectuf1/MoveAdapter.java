package com.example.finalprojectuf1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {
    private Context context;
    private List<Move> moveList;

    public MoveAdapter(Context context, List<Move> moveList) {
        this.context = context;
        this.moveList = moveList;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_move, parent, false);
        return new MoveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
        Move move = moveList.get(position);
        holder.name.setText(move.getName());
        holder.description.setText(move.getDescription());
        holder.category.setText("Categoría: " + move.getCategory());
        holder.difficulty.setText("Dificultad: " + move.getDifficulty());
        holder.image.setImageResource(move.getImageResId());
        holder.learned.setChecked(move.isLearned());

        holder.learned.setOnCheckedChangeListener((buttonView, isChecked) -> move.setLearned(isChecked));

        holder.videoButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(move.getVideoUrl()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, category, difficulty;
        ImageView image;
        CheckBox learned;
        Button videoButton;

        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.move_name);
            description = itemView.findViewById(R.id.move_description);
            category = itemView.findViewById(R.id.move_category);
            difficulty = itemView.findViewById(R.id.move_difficulty);
            image = itemView.findViewById(R.id.move_image);
            learned = itemView.findViewById(R.id.move_learned);
            videoButton = itemView.findViewById(R.id.move_video_button);
        }
    }
}
