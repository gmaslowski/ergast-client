package com.gmaslowski.ergast;

import com.google.common.base.Objects;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;

class EGDriver {

    private String driverId;
    private String driverUrl;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    private String code;

    @Override
    public int hashCode() {
        return Objects.hashCode(driverId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EGDriver)) {
            return false;
        }
        return equal(driverId, ((EGDriver) obj).driverId);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("driverId", driverId)
                .add("givenName", givenName)
                .add("familyName", familyName)
                .toString();
    }
}
