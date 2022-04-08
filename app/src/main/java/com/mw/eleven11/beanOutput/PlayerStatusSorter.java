package com.mw.eleven11.beanOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerStatusSorter {
    List<ResponseLivePlayerStatus.ResponseBean> jobCandidate = new ArrayList<>();

    public PlayerStatusSorter(List<ResponseLivePlayerStatus.ResponseBean> jobCandidate) {
        this.jobCandidate = jobCandidate;
    }

    public List<ResponseLivePlayerStatus.ResponseBean> getSortedSelectedBy(int i) {
        Collections.sort(jobCandidate, ResponseLivePlayerStatus.ResponseBean.selectedByComparator);
        if (i == 0)//o mean ascending 1 mean descending order
            Collections.reverse(jobCandidate);

        return jobCandidate;
    }

    public List<ResponseLivePlayerStatus.ResponseBean> getTotalPointComparator(int i) {
        Collections.sort(jobCandidate, ResponseLivePlayerStatus.ResponseBean.totalPointComparator);
        if (i == 0)//o mean ascending 1 mean descending order
            Collections.reverse(jobCandidate);

        return jobCandidate;
    }
}
