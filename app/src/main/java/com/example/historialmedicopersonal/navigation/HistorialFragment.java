package com.example.historialmedicopersonal.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.historialmedicopersonal.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class HistorialFragment extends Fragment {

    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private RecyclerView historialRecyclerView;
    private HistorialAdapter historialAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_historial, container, false);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        historialRecyclerView = view.findViewById(R.id.historialRecyclerView);
        historialRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        historialAdapter = new HistorialAdapter(new ArrayList<>());
        historialRecyclerView.setAdapter(historialAdapter);

        loadHistorialData();
        return view;
    }

    private void loadHistorialData() {
        String userId = auth.getCurrentUser().getUid();

        db.collection("Historial")
                .whereEqualTo("userId", userId)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Historial> historialList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Historial historial = document.toObject(Historial.class);
                            historialList.add(historial);
                        }
                        historialAdapter.updateData(historialList);
                    } else {
                        Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
