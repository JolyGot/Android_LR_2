package mai.team1.lab2;

private class CrimeHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getId());
        Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.
                getId());
        startActivity(intent);
    }
}
