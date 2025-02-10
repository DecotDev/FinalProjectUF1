package com.example.finalprojectuf1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class MovesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MoveAdapter adapter;
    private List<Move> moveList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moves, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewMoves);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        moveList = new ArrayList<>();
        moveList.add(new Move("Kong Vault", "Un salto apoyándose con las manos", R.drawable.baseline_directions_run_24, 6, "Vaults", "https://www.youtube.com/watch?v=kongvault", false));
        moveList.add(new Move("Wall Run", "Correr por la pared para alcanzar un punto alto", R.drawable.baseline_directions_run_24, 8, "Climbing", "https://www.youtube.com/watch?v=wallrun", false));
        moveList.add(new Move("Precision Jump", "Salto con precisión de un punto a otro", R.drawable.baseline_directions_run_24, 5, "Jumps", "https://www.youtube.com/watch?v=precisionjump", false));

        adapter = new MoveAdapter(getContext(), moveList);
        recyclerView.setAdapter(adapter);
    }
}
