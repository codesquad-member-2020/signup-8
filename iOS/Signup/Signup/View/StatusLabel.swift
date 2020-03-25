//
//  StatusLabel.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/25.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class StatusLabel: UILabel {
    enum State: String {
        case LongLength = "ID는 20글자 이하여야 합니다."
        case ShortLength = "ID는 5글자 이상이어야 합니다."
        case InvalidID = "영문 소문자, 숫자, 특수기호(_, -)를 사용해야합니다."
        case DuplicateID = "이미 사용 중인 ID 입니다."
        case OK = "사용 가능한 ID 입니다."
        case Normal
    }
    
    private var state: State {
        didSet {
            changeText(status: state)
        }
    }
    
    override init(frame: CGRect) {
        state = .Normal
        super.init(frame: frame)
        alpha = 0
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(isValid(_:)),
                                               name: .isValidID,
                                               object: nil)
    }
    
    required init?(coder: NSCoder) {
        state = .Normal
        super.init(coder: coder)
        alpha = 0
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(isValid(_:)),
                                               name: .isValidID,
                                               object: nil)
    }
    
    deinit {
        NotificationCenter.default.removeObserver(self)
    }
    
    private func changeText(status: State) {
        text = status.rawValue
        alpha = 1
        switch status {
        case .DuplicateID,.InvalidID,.LongLength,.ShortLength:
            textColor = UIColor(named: "Red") ?? .red
        case .Normal:
            textColor = UIColor(named: "Gray") ?? .gray
        case .OK:
            textColor = UIColor(named: "Green") ?? .systemGreen
        }
    }
    
    @objc func isValid(_ notification: Notification) {
        if let info: [String : State] = notification.userInfo as? [String : State] {
            state = info["state"] ?? State.Normal
        }
    }
}
