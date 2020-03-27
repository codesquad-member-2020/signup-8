//
//  TermsViewController.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/27.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class TermsViewController: UIViewController {

    @IBOutlet weak var termsTextView: UITextView!
    let termTextViewDelegate = TermTextViewDelegate()
    override func viewDidLoad() {
        super.viewDidLoad()
        termsTextView.delegate = termTextViewDelegate
        termsTextView.isEditable = false
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(showAlert(_:)),
                                               name: .reachBottom,
                                               object: nil)
    }
    
    @objc func showAlert(_ notification: Notification) {
        let actionSheet = UIAlertController()
        let agreeAction = UIAlertAction(title: "동의", style: .default) { _ in
            
        }
        agreeAction.setValue(UIColor(named: "Green"), forKey: "titleTextColor")
        actionSheet.addAction(agreeAction)
        
        actionSheet.addAction(UIAlertAction(title: "취소", style: .cancel){ _ in
            self.dismiss(animated: true)
        })
        
        self.present(actionSheet, animated: true, completion: nil)
    }
}
