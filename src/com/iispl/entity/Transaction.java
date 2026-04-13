package com.iispl.entity;

public final class Transaction {

    private final String transactionId;
    private final String fromAccount;   
    private final String toAccount;     
    private final double amount;
    private final String channel;       
    private final String status;        

    public Transaction(String transactionId,
                       String fromAccount,
                       String toAccount,
                       double amount,
                       String channel,
                       String status) {

        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or blank.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Transaction amount cannot be negative.");
        }

        this.transactionId = transactionId;
        this.fromAccount   = fromAccount;
        this.toAccount     = toAccount;
        this.amount        = amount;
        this.channel       = channel;
        this.status        = status;
    }

    public String getTransactionId() { return transactionId; }
    public String getFromAccount()   { return fromAccount;   }
    public String getToAccount()     { return toAccount;     }
    public double getAmount()        { return amount;        }
    public String getChannel()       { return channel;       }
    public String getStatus()        { return status;        }

    @Override
    public String toString() {
        return String.format(
            "| %-10s | %-12s | %-12s | %12.2f | %-12s | %-8s |",
            transactionId, fromAccount, toAccount, amount, channel, status
        );
    }
}