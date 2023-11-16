package mai.team1.lab2;


import static java.text.DateFormat.getDateInstance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.view.MenuItemCompat;
import android.content.Context;


import java.util.List;



public class CrimeListFragment extends Fragment {

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private boolean mSubtitleVisible;

    private mai.team1.lab2.CrimeListFragment.Callbacks mCallbacks;

    public interface Callbacks { void onCrimeSelected(Crime crime);}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (mai.team1.lab2.CrimeListFragment.Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }



    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if (item.getItemId() == R.id.new_crime) {
            Crime crime = new Crime();
            CrimeLab.get(getActivity()).addCrime(crime);
            updateUI();
            mCallbacks.onCrimeSelected(crime);
            return true;
        }
        else if (item.getItemId() == R.id.show_subtitle){
        mSubtitleVisible = !mSubtitleVisible;
        getActivity().invalidateOptionsMenu();
        updateSubtitle();
        return true;
        }
         else   return super.onOptionsItemSelected(item);
    }

        private void updateSubtitle() {
            CrimeLab crimeLab = CrimeLab.get(getActivity());
            int crimeCount = crimeLab.getCrimes().size();
            @SuppressLint("StringFormatMatches") String subtitle = getString(R.string.subtitle_format, crimeCount);

            if (!mSubtitleVisible) {
                subtitle = null;
            }

            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.getSupportActionBar().setSubtitle(subtitle);
        }

        public void updateUI () {
            CrimeLab crimeLab = CrimeLab.get(getActivity());
            List<Crime> crimes = crimeLab.getCrimes();
            if (mAdapter == null) {
                mAdapter = new CrimeAdapter(crimes);
                mCrimeRecyclerView.setAdapter(mAdapter);
            } else {
                mAdapter.setCrimes(crimes);
                mAdapter.notifyDataSetChanged();
            }
            updateSubtitle();
        }

        private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private Crime mCrime;
            private TextView mTitleTextView;
            private TextView mDateTextView;
            private CheckBox mSolvedCheckBox;



            public CrimeHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);

                mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
                mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
                mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.crime_solved);

            }

            public void bindCrime(Crime crime) {
                mCrime = crime;
                mTitleTextView.setText(mCrime.getTitle());
                mSolvedCheckBox.setChecked(mCrime.isSolved());
                mDateTextView.setText(getDateInstance().format(mCrime.getDate()));

            }
            @Override
            public void onClick(View view) {
                mCallbacks.onCrimeSelected(mCrime);
            }
        }

            private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
                private List<Crime> mCrimes;

                public CrimeAdapter(List<Crime> crimes) {

                    mCrimes = crimes;
                }

                @Override
                public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                    View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
                    return new CrimeHolder(view);
                }

                @Override
                public void onBindViewHolder(CrimeHolder holder, int position) {
                    Crime crime = mCrimes.get(position);
                    holder.bindCrime(crime);
                }

                @Override
                public int getItemCount() {

                    return mCrimes.size();
                }
                public void setCrimes(List<Crime> crimes) {
                    mCrimes = crimes;
                }


            }

}
