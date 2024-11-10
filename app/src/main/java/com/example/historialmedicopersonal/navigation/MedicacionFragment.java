package com.example.historialmedicopersonal.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.historialmedicopersonal.MedicacionAdapter;
import com.example.historialmedicopersonal.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MedicacionFragment extends Fragment {

    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private RecyclerView medicacionRecyclerView;
    private MedicacionAdapter medicacionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicacion, container, false);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        medicacionRecyclerView = view.findViewById(R.id.medicacionRecyclerView);
        medicacionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        medicacionAdapter = new MedicacionAdapter(new ArrayList<>());
        medicacionRecyclerView.setAdapter(medicacionAdapter);

        loadMedicacionData();
        return view;
    }

    private void loadMedicacionData() {
        String userId = auth.getCurrentUser().getUid();

        db.collection("Medicacion")
                .whereEqualTo("userId", userId)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Medicacion> medicacionList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Medicacion medicacion = document.toObject(Medicacion.class);
                            medicacionList.add(medicacion);
                        }
                        medicacionAdapter.updateData(medicacionList);
                    } else {
                        Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
